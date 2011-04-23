import groovy.io.FileType
import groovy.sql.Sql
import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement

dbFolder = getBranchRoot() + "/database";
def props = [user: 'bmdev', password: 'bm123456', allowMultiQueries: 'true'] as Properties
def url = 'jdbc:mysql://localhost:3306/'
def driver = 'com.mysql.jdbc.Driver'
def sql = Sql.newInstance(url, props, driver)

new File('.').eachFile FileType.DIRECTORIES, {
  String name = it.getName();
  if (name == ".svn" ||
          name == "lib")
    return;

  println "Droping database '${name}'";
  sql.execute("DROP DATABASE IF EXISTS " + name)

  println "Importing database '${name}'"
  File baseFile = new File("base.sql", (File) it);
  if (!baseFile.exists())
    throw new RuntimeException("Base file doesn't exist: " + baseFile.getAbsoluteFile());

  base = baseFile.getText();
  sql.execute("CREATE DATABASE " + name)
  sql.execute("USE " + name + "; " + base);
}

String getBranchRoot() {
  String path = "." + File.separator;
  while (true) {
    if (path.length() > 200) // some sanity limit
      throw new RuntimeException("Failed to find branch root - this should only be called from within the Delver folder structure");

    if (new File(path + "java").exists() &&
            new File(path + "database").exists())
      return path;

    path += ".." + File.separator;
  }
}
