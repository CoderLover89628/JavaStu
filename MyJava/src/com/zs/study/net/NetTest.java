package com.zs.study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NetTest nt = new NetTest();
		/*nt.getHostName();
		nt.getLocalIp();
		nt.getOSName();*/
		nt.getIPbyName();
	}

	/**
	 * 获得指定主机的IP
	 */
	public void getIPbyName() {
		InetAddress address = null;
	      try {
	         address = InetAddress.getByName
	         ("www.runoob.com");
	      }
		  catch (UnknownHostException e) {
			  System.out.println("fail");
	         System.exit(2);
	      }
	      System.out.println(address.getHostName() + "="
	      + address.getHostAddress());
	      System.exit(0);
	}
	
	/**
	 * 获取本地IP地址
	 * @return
	 */
	public String getLocalIp(){
		String ip = "";
		try{
            // 获取IP地址
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            System.out.println("获取本地IP地址异常：" + e);
            e.printStackTrace();
        }
		System.out.println("this machine's IP is: " + ip);
		return ip;
	}
	
    /**
	 * 获取本机计算机名称
	 * @return	本机计算机名
	 * @throws UnknownHostException
	 */
	public String getHostName(){
		String ret = "";
		try{
			InetAddress s = InetAddress.getLocalHost();  
	        ret = s.getHostName();
		}catch(UnknownHostException e){
			System.out.println("获取本地计算机名异常");
			e.printStackTrace();
		}
		System.out.println("this machine's machineName is: " + ret);
        return ret;
	}
	
	/**
	 * 获取当前系统名称
	 * 
	 * @return
	 */
	public String getOSName() {
		String osName = "";
		osName = System.getProperty("os.name").toLowerCase(); 
		System.out.println("this machine's OS is: " + osName);
		return osName;
	}
	
	 /**   
     * 获取Unix网卡的mac地址.   
    * @return mac地址   
    */     
   public static String getUnixMACAddress() {     
       String mac = null;     
       BufferedReader bufferedReader = null;     
       Process process = null;     
       try {     
             /**  
              *  Unix下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息    
              */  
           process = Runtime.getRuntime().exec("ifconfig eth0");   
           bufferedReader = new BufferedReader(new InputStreamReader(process     
                   .getInputStream()));     
           String line = null;     
           int index = -1;     
           while ((line = bufferedReader.readLine()) != null) {     
                  /**  
                   *  寻找标示字符串[hwaddr]   
                   */  
               index = line.toLowerCase().indexOf("hwaddr");    
                  /**  
                   * 找到了  
                   */  
               if (index != -1) {     
                      /**  
                       *   取出mac地址并去除2边空格    
                       */  
                   mac = line.substring(index +"hwaddr".length()+ 1).trim();   
                   break;     
               }     
           }     
       } catch (IOException e) {     
           e.printStackTrace();     
       } finally {     
           try {     
               if (bufferedReader != null) {     
                   bufferedReader.close();     
               }     
           } catch (IOException e1) {     
              e1.printStackTrace();     
          }     
           bufferedReader = null;     
           process = null;     
       }     
    
       return mac;     
   }     
        
          
          
       /**   
         * 获取Linux网卡的mac地址.   
        * @return mac地址   
        */     
       public static String getLinuxMACAddress() {     
           String mac = null;     
           BufferedReader bufferedReader = null;     
           Process process = null;     
           try {     
                 /**  
                  *  linux下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息    
                  */  
               process = Runtime.getRuntime().exec("ifconfig eth0");   
               bufferedReader = new BufferedReader(new InputStreamReader(process     
                       .getInputStream()));     
               String line = null;     
               int index = -1;     
               while ((line = bufferedReader.readLine()) != null) {     
                   index = line.toLowerCase().indexOf("硬件地址");    
                      /**  
                       * 找到了  
                       */  
                   if (index != -1) {     
                          /**  
                           *   取出mac地址并去除2边空格    
                           */  
                       mac = line.substring(index+4).trim();   
                       break;     
                   }     
               }     
           } catch (IOException e) {     
               e.printStackTrace();     
           } finally {     
               try {     
                   if (bufferedReader != null) {     
                       bufferedReader.close();     
                   }     
               } catch (IOException e1) {     
                  e1.printStackTrace();     
              }     
               bufferedReader = null;     
               process = null;     
           }   
        
           return mac;     
       }   
          
       /**   
        * 获取widnows网卡的mac地址.   
        * @return mac地址   
        */     
       public static String getWindowsMACAddress() {     
           String mac = null;     
           BufferedReader bufferedReader = null;     
           Process process = null;     
           try {     
                 /**  
                  * windows下的命令，显示信息中包含有mac地址信息    
                  */  
               process = Runtime.getRuntime().exec("ipconfig /all");   
               bufferedReader = new BufferedReader(new InputStreamReader(process     
                       .getInputStream()));     
               String line = null;     
               int index = -1;     
               while ((line = bufferedReader.readLine()) != null) {     
                      /**  
                       *  寻找标示字符串[physical address]   
                       */  
                   index = line.toLowerCase().indexOf("physical address");    
                   if (index != -1) {   
                       index = line.indexOf(":");   
                       if (index != -1) {   
                              /**  
                               *   取出mac地址并去除2边空格  
                               */  
                          mac = line.substring(index + 1).trim();    
                      }   
                       break;     
                   }   
               }   
           } catch (IOException e) {     
               e.printStackTrace();     
           }finally {     
               try {     
                   if (bufferedReader != null) {     
                       bufferedReader.close();     
                     }     
               }catch (IOException e1) {     
                   e1.printStackTrace();     
                 }     
               bufferedReader = null;     
               process = null;     
           }     
        
           return mac;     
       }      
}
