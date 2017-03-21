package com.fs.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 根据数据库生成代码
 */
public class Generator {
    static String packageName = "com.fs.bar.entity";
    static String javaFilePackage = "F:\\git-workspace\\wangbar\\src\\main\\java\\com\\fs\\bar\\entity\\";
    static String xmlFilePackage = "F:\\git-workspace\\wangbar\\src\\main\\java\\com\\fs\\bar\\entity\\mapper\\";
    static String delPrefix = "";
    static String url = "jdbc:mysql://60.205.220.63:3306/wbar?"
            + "user=root&password=feng123D&useUnicode=true&characterEncoding=utf-8&useSSL=false&noAccessToProcedureBodies=true";


    public static void generateBeanAndXml(String table_name) {
        java.sql.Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);

            java.sql.DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tabs = metaData.getTables(null, "%", table_name, new String[]{"TABLE"});
            //获取�?���?
            while (tabs.next()) {
                Map<String, String> mapperData = new LinkedHashMap();
                //获取表名
                String tableName = (String) tabs.getObject("TABLE_NAME");
                //处理表结�?
                ResultSet colRet = metaData.getColumns(null, "%", tableName, "%");
                String fileName = getClassName(tableName);

                File javaFile = new File(javaFilePackage + fileName + ".java");
                BufferedWriter javaWriter = null;
                boolean javaFileFlag=true,xmlFileFlag=true;
                if (!javaFile.exists()) {
                    javaFileFlag=false;
                    javaFile.createNewFile();
                    javaWriter = new BufferedWriter(new FileWriter(javaFile));
                    javaWriter.write("package " + packageName + ";");
                    javaWriter.newLine();
                    javaWriter.write("import java.io.Serializable;\nimport java.util.Date;");
                    javaWriter.newLine();
                    javaWriter.write("public class " + fileName + " implements Serializable{");
                    javaWriter.newLine();
                    javaWriter.write("private static final long serialVersionUID = 1L;");
                    javaWriter.newLine();
                }
                File xmlFile = new File(xmlFilePackage + fileName + ".xml");

                BufferedWriter xmlWriter = null;
                if (!xmlFile.exists()) {
                    xmlFileFlag=false;
                    xmlFile.createNewFile();

                    xmlWriter = new BufferedWriter(new FileWriter(xmlFile));


                    xmlWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
                    xmlWriter.newLine();
                    xmlWriter.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
                    xmlWriter.newLine();
                    xmlWriter.write("<mapper namespace=\"cn.etsk.api.entity.domain." + fileName + "\">");
                    xmlWriter.newLine();
                    xmlWriter.write("<resultMap type=\"" + packageName + "." + fileName + "\" id=\"" + fileName + "\">");
                    xmlWriter.newLine();
                }


                String getSetMethods = "";
                while (colRet.next()) {
                    String columnName = colRet.getString("COLUMN_NAME");
                    String columnType = colRet.getString("TYPE_NAME");
                    String columnNameReal = getColumnName(columnName);

                    if (!javaFileFlag) {


                        javaWriter.write("private " + getcolumnType(columnType) + " " + columnNameReal + ";" + "//" + colRet.getString("REMARKS"));
                        javaWriter.newLine();
                    }

                    if (!xmlFileFlag) {


                        xmlWriter.write("      <id column=\"" + columnName + "\" property=\"" + columnNameReal + "\"/>");
                        xmlWriter.newLine();
                        mapperData.put(columnName, columnNameReal);
                    }

                    getSetMethods += "\npublic " + getcolumnType(columnType) + " get" + columnNameReal.substring(0, 1).toUpperCase() + columnNameReal.substring(1, columnNameReal.length()) + "(){\n" +
                            "return " + columnNameReal + ";\n" +
                            "}\n\n" +
                            "public void set" + columnNameReal.substring(0, 1).toUpperCase() + columnNameReal.substring(1, columnNameReal.length()) + "(" + getcolumnType(columnType) + " " + columnNameReal + ") {\n" +
                            "this." + columnNameReal + " = " + columnNameReal + ";\n" +
                            "}\n";

                }

                if (!javaFileFlag) {


                    javaWriter.write(getSetMethods);
                    javaWriter.write("}");
                    javaWriter.flush();
                }


                if (!xmlFileFlag){


                    xmlWriter.write("</resultMap>");
                    //xml增删改查
                    generateSql(xmlWriter, mapperData, fileName, tableName);


                    xmlWriter.newLine();
                    xmlWriter.write("</mapper>");
                    xmlWriter.flush();
                }
            }


        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    /**
     * @param xmlWriter
     * @param mapperData
     * @throws IOException
     * @description: 增删改查语句
     * @author pineF
     * @time 2016-9-18 下午4:33:15
     */
    private static void generateSql(BufferedWriter xmlWriter,
                                    Map<String, String> mapperData, String fileName, String tableName) throws IOException {
        String saveBlockSrc = "	insert into " + tableName + "(";
        String saveBlockValue = "values(";
        String updateBlock = "	update " + tableName + " set ";
        String conditionBlock = "";
        for (Entry<String, String> entry : mapperData.entrySet()) {
            saveBlockSrc += entry.getKey() + ",";
            saveBlockValue += "#{" + entry.getValue() + "},";
            if (!entry.getKey().equals("ID")) {
                updateBlock += entry.getKey() + "=#{" + entry.getValue() + "},";

                conditionBlock += "<if test=\"" + entry.getValue() + "!=null and " + entry.getValue() + "!=''\">\n" +
                        "    and " + entry.getKey() + "=#{" + entry.getValue() + "} \n</if>\n";
            }


        }

        saveBlockSrc = saveBlockSrc.substring(0, saveBlockSrc.length() - 1);
        saveBlockValue = saveBlockValue.substring(0, saveBlockValue.length() - 1);
        updateBlock = updateBlock.substring(0, updateBlock.length() - 1);

        xmlWriter.write("<!--接口说明:新增" + tableName + "数据-->\n");
        xmlWriter.write("<insert id=\"save\" parameterType=\"" + fileName + "\">");
        xmlWriter.newLine();
        xmlWriter.write(saveBlockSrc + ")" + saveBlockValue + ")");
        xmlWriter.newLine();
        xmlWriter.write("</insert>");
        xmlWriter.newLine();
        xmlWriter.newLine();

        xmlWriter.write("<!--接口说明:修改" + tableName + "数据-->\n");
        xmlWriter.write("<update id=\"update\" parameterType=\"" + fileName + "\">");
        xmlWriter.newLine();
        xmlWriter.write(updateBlock + " WHERE ID=#{id}");
        xmlWriter.newLine();
        xmlWriter.write("</update>");
        xmlWriter.newLine();
        xmlWriter.newLine();

        xmlWriter.write("<!--接口说明:删除" + tableName + "数据-->\n");
        xmlWriter.write("<delete id=\"deleteById\" parameterType=\"int\"> \n" +
                "	delete from TEACHER where ID=#{id}\n" +
                "</delete>");
        xmlWriter.newLine();
        xmlWriter.newLine();

        xmlWriter.write("<!--根据map参数查询" + tableName + "数据-->\n");
        xmlWriter.write("<select id=\"findOneByMap\" parameterType=\"java.util.Map\" resultMap=\"" + fileName + "\">");
        xmlWriter.newLine();
        xmlWriter.write("	select a.* from " + tableName + " a where 1=1 \n");
        xmlWriter.write("	limit 0,1 \n");
        xmlWriter.write("</select>");
        xmlWriter.newLine();
        xmlWriter.newLine();


        xmlWriter.write("<!--根据map参数查询" + tableName + "数据-->\n");
        xmlWriter.write("<select id=\"findByMap\" parameterType=\"java.util.Map\" resultMap=\"" + fileName + "\">");
        xmlWriter.newLine();
        xmlWriter.write("	select * from " + tableName + "  where 1=1 \n");
        xmlWriter.write(conditionBlock);
        xmlWriter.write("</select>");
        xmlWriter.newLine();
        xmlWriter.newLine();

        xmlWriter.write("<!--查询所有" + tableName + "数据-->\n");
        xmlWriter.write("<select id=\"findAll\" resultMap=\"" + fileName + "\">\n" +
                "	select * from " + tableName + " \n"
                + "</select>");
        xmlWriter.newLine();
        xmlWriter.newLine();

        xmlWriter.write("<!--根据条件查询" + tableName + "表数据-->\n");
        xmlWriter.write("<select id=\"queryCount\" parameterType=\"java.util.Map\" resultType=\"int\">");
        xmlWriter.newLine();
        xmlWriter.write("	select count(1) from " + tableName + "  where 1=1  \n");
        xmlWriter.write("</select>");
        xmlWriter.newLine();
        xmlWriter.newLine();

    }

    private static String getColumnName(String columnName) {
        columnName = getClassName(columnName);
        return columnName.substring(0, 1).toLowerCase() + columnName.substring(1);
    }

    private static String getcolumnType(String columnType) {

        if (columnType.equals("BIGINT")) {
            return "Long";
        }

        if (columnType.equals("INT")) {
            return "Integer";
        }

        if (columnType.equals("DATETIME") || columnType.equals("DATE")) {
            return "Date";
        }

        if (columnType.equals("TINYINT")) {
            return "Integer";
        }

        if (columnType.equals("VARCHAR")) {
            return "String";
        }

        if (columnType.equals("DOUBLE")) {
            return "double";
        }

        if (columnType.equals("FLOAT")) {
            return "float";
        }

        System.out.println(columnType);
        return "Null";
    }

    public static String getClassName(String tableName) {
        String name = new String(tableName).replace(delPrefix, "");
        if (name.contains("_")) {
            return getClassName(name.substring(0, name.indexOf("_"))) + getClassName(name.substring(name.indexOf("_") + 1));
        } else {
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

    }

    public static void main(String[] args) {
        generateBeanAndXml(null);
    }
}
