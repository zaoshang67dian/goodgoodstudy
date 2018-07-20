package com.good.good.study.daydayup.jvm.classloader;

import java.io.*;

/**
 * @author shipj@ctrip.com
 * @date 2018/7/20 9:31
 */
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取class文件字节数组
        byte[] classData = getClassData(name);
        if(null == classData){
            throw new ClassNotFoundException();
        }else {
            //直接生成Class对象
            return defineClass(name,classData,0,classData.length);
        }
    }

    private byte[] getClassData(String name){
        //读取类文件的字节
        String path = classNameToPath(name);
        InputStream ins = null;
        ByteArrayOutputStream baos = null;

        try {
            ins = new FileInputStream(path);
            baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            //读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1){
                baos.write(buffer,0,bytesNumRead);
            }

            return baos.toByteArray();
        } catch (Exception e) {
            //
        } finally {
            //region **** 关闭资源
            if(null != ins){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != baos){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //endregion
        }
        return null;
    }

    /**
     * 根据类名和root路径获取需要加载的类的全限定名
     * @param className 类名称
     * @return 需要加载的类的全限定名
     */
    private String classNameToPath(String className){
        return rootDir + File.separatorChar +  className.replace('.',File.separatorChar) + ".class";
    }

    public static void main(String[] args) {
        String rootDir = "E:\\自学与培训\\goodgoodstudy\\demo\\src\\main\\java";

        FileClassLoader classLoader = new FileClassLoader(rootDir);

        try {
            Class<?> object1 = classLoader.loadClass("com.good.good.study.daydayup.jvm.classloader.MyClass");

            System.out.println(object1.newInstance().toString());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
