# springboot系统化学习
## 开发工具
### maven
#### 下载地址：https://maven.apache.org/download.cgi
#### setting配置文件说明
     为了更快的下载第三方依赖包，可以配置国内的仓库，配置参考如下：
     	
     
      < !-- 在mirrors 中配置 mirror -->
      <mirror>
        <id>alimaven</id>
        <name>aliyun maven</name>
        <url>
            http://maven.aliyun.com/nexus/content/groups/public/
        </url>
        <mirrorOf>central</mirrorOf>        
      </mirror>
      
     可以下载setting.xml文件放到maven的conf目录下直接使用
### eclipse
#### 版本：Oxygen.2 Release (4.7.2)
#### 配置maven
#### 安装sts
##### 下载地址：https://spring.io/tools/sts/all
##### 安装方式：
###### 1.直接下载集成sts的eclipse
###### 2.下载sts zip包，导入eclipse
###### 3.在线安装：http://dist.springsource.com/release/TOOLS/update/e4.7/
##### 安装：
###### eclipse中的help---》install new software打开安装页面选择zip包或者在线安装即可
       
