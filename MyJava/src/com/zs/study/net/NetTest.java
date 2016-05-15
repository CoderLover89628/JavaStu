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
	 * ���ָ��������IP
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
	 * ��ȡ����IP��ַ
	 * @return
	 */
	public String getLocalIp(){
		String ip = "";
		try{
            // ��ȡIP��ַ
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            System.out.println("��ȡ����IP��ַ�쳣��" + e);
            e.printStackTrace();
        }
		System.out.println("this machine's IP is: " + ip);
		return ip;
	}
	
    /**
	 * ��ȡ�������������
	 * @return	�����������
	 * @throws UnknownHostException
	 */
	public String getHostName(){
		String ret = "";
		try{
			InetAddress s = InetAddress.getLocalHost();  
	        ret = s.getHostName();
		}catch(UnknownHostException e){
			System.out.println("��ȡ���ؼ�������쳣");
			e.printStackTrace();
		}
		System.out.println("this machine's machineName is: " + ret);
        return ret;
	}
	
	/**
	 * ��ȡ��ǰϵͳ����
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
     * ��ȡUnix������mac��ַ.   
    * @return mac��ַ   
    */     
   public static String getUnixMACAddress() {     
       String mac = null;     
       BufferedReader bufferedReader = null;     
       Process process = null;     
       try {     
             /**  
              *  Unix�µ����һ��ȡeth0��Ϊ���������� ��ʾ��Ϣ�а�����mac��ַ��Ϣ    
              */  
           process = Runtime.getRuntime().exec("ifconfig eth0");   
           bufferedReader = new BufferedReader(new InputStreamReader(process     
                   .getInputStream()));     
           String line = null;     
           int index = -1;     
           while ((line = bufferedReader.readLine()) != null) {     
                  /**  
                   *  Ѱ�ұ�ʾ�ַ���[hwaddr]   
                   */  
               index = line.toLowerCase().indexOf("hwaddr");    
                  /**  
                   * �ҵ���  
                   */  
               if (index != -1) {     
                      /**  
                       *   ȡ��mac��ַ��ȥ��2�߿ո�    
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
         * ��ȡLinux������mac��ַ.   
        * @return mac��ַ   
        */     
       public static String getLinuxMACAddress() {     
           String mac = null;     
           BufferedReader bufferedReader = null;     
           Process process = null;     
           try {     
                 /**  
                  *  linux�µ����һ��ȡeth0��Ϊ���������� ��ʾ��Ϣ�а�����mac��ַ��Ϣ    
                  */  
               process = Runtime.getRuntime().exec("ifconfig eth0");   
               bufferedReader = new BufferedReader(new InputStreamReader(process     
                       .getInputStream()));     
               String line = null;     
               int index = -1;     
               while ((line = bufferedReader.readLine()) != null) {     
                   index = line.toLowerCase().indexOf("Ӳ����ַ");    
                      /**  
                       * �ҵ���  
                       */  
                   if (index != -1) {     
                          /**  
                           *   ȡ��mac��ַ��ȥ��2�߿ո�    
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
        * ��ȡwidnows������mac��ַ.   
        * @return mac��ַ   
        */     
       public static String getWindowsMACAddress() {     
           String mac = null;     
           BufferedReader bufferedReader = null;     
           Process process = null;     
           try {     
                 /**  
                  * windows�µ������ʾ��Ϣ�а�����mac��ַ��Ϣ    
                  */  
               process = Runtime.getRuntime().exec("ipconfig /all");   
               bufferedReader = new BufferedReader(new InputStreamReader(process     
                       .getInputStream()));     
               String line = null;     
               int index = -1;     
               while ((line = bufferedReader.readLine()) != null) {     
                      /**  
                       *  Ѱ�ұ�ʾ�ַ���[physical address]   
                       */  
                   index = line.toLowerCase().indexOf("physical address");    
                   if (index != -1) {   
                       index = line.indexOf(":");   
                       if (index != -1) {   
                              /**  
                               *   ȡ��mac��ַ��ȥ��2�߿ո�  
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
