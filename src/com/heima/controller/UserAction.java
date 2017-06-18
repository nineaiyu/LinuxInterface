/**
* Title:
* Description: 
* Company: @hulian 
* @author songGuo
* @date 2016-12-3 下午02:21:26
*/
package com.heima.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heima.pojo.Admin;
import com.heima.pojo.App;
import com.heima.pojo.K8s;
import com.heima.pojo.Services;
import com.heima.pojo.User;
import com.heima.service.AdminServiceI;
import com.heima.service.AppServiceI;
import com.heima.service.DeptServiceI;
import com.heima.service.K8sServiceI;
import com.heima.service.SSHCmdServiceI;
import com.heima.service.ServicesServiceI;
import com.heima.service.UserServiceI;
import com.heima.service.CmdServiceI;
import com.heima.util.GetSession;
import com.heima.util.PageUtils;
import com.heima.util.getPasswd;
import com.heima.vo.UserVo;

/**
 * Title:
 * Description: 
 * Company: @hulian 
 * @author songGuo
 * @date 2016-12-3 下午02:21:26
 */
@Controller
public class UserAction {
	
	
	@Autowired
	@Qualifier("userService")
	private UserServiceI userService;
	
	@Autowired
	@Qualifier("appService")
	private AppServiceI appService;
	
	@Autowired
	@Qualifier("sshcmdService")
	private SSHCmdServiceI sshcmdService;
	
	@Autowired
	@Qualifier("servicesService")
	private ServicesServiceI servicesService;
	
	@Autowired
	@Qualifier("deptService")
	private DeptServiceI deptService;
	
	@Autowired
	@Qualifier("cmdService")
	private CmdServiceI cmdService;
	
	@Autowired
	@Qualifier("adminService")
	private AdminServiceI adminService;
	
	@Autowired
	@Qualifier("k8sService")
	private K8sServiceI k8sService;
	
	
//	@Autowired
//	@Qualifier("user")
//	private User user;
	private User user=new User();
	
	
	//获取列表
	@RequestMapping("list.action")
	public String list(HttpServletRequest request) throws Exception{
		String item = request.getParameter("item");
		String page = request.getParameter("page");
		if(item!=null){
//			if(!"".equals(item.trim())){
//			    item=new String(item.trim().getBytes("iso-8859-1"),"utf-8");
//			}
			item=new String(item.getBytes("iso-8859-1"),"utf-8");
		}else{
			item="";
		}
		//System.out.println(item+"--------");
		//获取count
		int count =userService.getUserCount(item);
		
		PageUtils pageUtils = new PageUtils(count, page, 3);
		int i=(pageUtils.getCurrentPage()-1)*3;
		UserVo userVo = new UserVo();
		userVo.setItem(item);
		userVo.setStartpage(i);
		userVo.setPagesize(3);
		List<User> list = userService.selectUserDeptMap(userVo);
		
		
		request.setAttribute("ulist", list);
		request.setAttribute("item", item);
		request.setAttribute("pageUtils", pageUtils);
		return "list";
	}
	
	//获取部门列表
	@ModelAttribute("dlist")
     public List deptList()throws Exception{
		List dlsit=deptService.getDList();
		return dlsit;
	}
	
	//跟新回显
	@RequestMapping("toupdate.action")
	@ResponseBody
	public User toupdate(User user) throws Exception{
		//System.out.println(user.getUid());
		user=userService.getUserByUid(user.getUid());
		return user;
	}
	
	//跟新回显
	@RequestMapping("update.action")
	public String  update(User user) throws Exception{
		System.out.println(user);
		//return "forward:list.action";
		userService.updateUser(user);
		return "redirect:list.action";
	}
	
	//新增user
	@RequestMapping("add.action")
	public String  add(User user) throws Exception{
		System.out.println(user);
		//return "forward:list.action";
		userService.addUser(user);
		return "redirect:list.action";
	}
	
	//通过uid删除user
	@RequestMapping("del.action")
	public String  del(User user) throws Exception{
		System.out.println(user.getUid());
		//return "forward:list.action";
		userService.delUser(user.getUid());
		return "redirect:list.action";
	}
	
	@RequestMapping("exits.action")
	public String  exits(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("name");
	    session.removeAttribute("userid");
	    session.invalidate();
	    return "login";
	}
	
	@RequestMapping("command.action")
	public String cmdinfos(HttpServletRequest request) throws Exception{
		String cmds = (String) request.getParameter("command");
		System.out.println("-------------------------comdinfois : "+cmds);
		if (cmds != null) {
			System.out.println("-------------------------not null------------------------");
			request.setAttribute("info", cmds);
			List<String> cmdlists = cmdService.command(cmds);
			System.out.println("commandlist---------------------"+cmdlists);
			request.setAttribute("infos", cmdlists); 

		return "cmdinfos";
		}
		return "login";
	}


	@RequestMapping("login.action")
	public String login(HttpServletRequest request) throws Exception{
		//if(GetSession.getsession(request)){
		
			String uname = (String) request.getParameter("uname");
			String upass = (String) request.getParameter("upass");
			
		
			if(adminService.getpasswd(uname) !=null && upass.equals(adminService.getpasswd(uname).getUpass())){
				System.out.println("认证成功");
				HttpSession session = request.getSession();
				session.setAttribute("name",uname );
				return "cmdinfos";	
		}
		request.setAttribute("uname", uname);
		request.setAttribute("upass", upass);
		request.setAttribute("error", "密码或账号不正确，请重新输入");
		return "login";	
	}
	
	@RequestMapping("siteinfos.action")
	public String siteinfos(HttpServletRequest request) throws Exception{
		String acts = request.getParameter("cmdacts");
		Services service = new Services();
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
	    System.out.println("用户如下:"+name);
		List<String> infos = null;
	    if(name != null){
	    if (acts.equals("deleteuser")) {
//	      infos = cmdService.DeleteUser(name);
	      infos = sshcmdService.DeleteUser(name);
	      System.out.println("删除用户");
	    }
	    else if (acts.equals("createuser")) {
//	      infos = cmdService.CreateUser(name);
	    
	    	String passwd = getPasswd.passwd(16);
	    	servicesService.addServices(service);
			infos = sshcmdService.CreateUser(name, passwd);
	    	
			service.setName(name);
			service.setServiceversion("2.2.2");
			service.setServicename("vsftpd");
			service.setIpandport("10.1.41.200:21");
			service.setAccount(name);
			service.setPassword(passwd);
			servicesService.addServices(service);
			infos = sshcmdService.CreateUser(name, passwd);
	      
	      
	      
	      System.out.println("创建用户");
	    }
	    }
	    for (String string : infos) {
			System.out.println(string);
		}
	    //session.setAttribute("ftpinfos", infos);
	    //request.setAttribute("infos", infos);
		//return "siteinfos";
	    return "redirect:appget.action";
	    
	}
//	站点基本信息表================================================================
	
	@RequestMapping("serviceadd.action")
	public String  serviceadd(Services service) throws Exception{
		System.out.println(user);
		//return "forward:list.action";
		userService.addUser(user);
		return "redirect:serviceget.action";
	}
	
	
	@RequestMapping("delservice.action")
	public String  delservice(HttpServletRequest request) throws Exception{
		String uid = request.getParameter("uid");
		System.out.println("del  uid : " +uid);
		List<String> infos = null;
		HttpSession session = request.getSession();
		
		String name = null;
		K8s k8s = new K8s();
		List<Services> list = servicesService.getServices(Integer.parseInt(uid));
		for (Services services : list) {
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			name = services.getName();
			
			if(services.getServicename().equals("vsftpd")){
					infos = sshcmdService.DeleteUser((String)session.getAttribute("name"));
					//session.setAttribute("ftpinfos", infos);
			}
			String strig = services.getIpandport();
			String[] ipandport=strig.split(":");
			
			k8s.setNamespaceName(name);
			k8s.setAppname(services.getServicename());
			k8s.setReplicas(1);
			k8s.setHostIP(ipandport[0]);
			k8s.setHostPort(Integer.valueOf(ipandport[1]));
			String HostPath = "/data/NFS/services/"+services.getServicename()+"/"+name+"/";
			k8s.setHostPath(HostPath);
			
			String imagename = "10.1.41.200:5000/"+services.getServicename()+"/"+services.getServicename()+":"+services.getServiceversion();
			k8s.setContainerImage(imagename);
			k8s.setCpu(2);
			k8s.setMem(2);
			if(services.getServicename().equals("httpd")){
				k8s.setContainerPort(80);
				k8s.setContainerPath("/var/www/html");
				k8s.setEnvname("null");
				k8s.setEnvalue("null");
			}else if(services.getServicename().equals("mysql")){
				k8s.setContainerPort(3306);
				k8s.setEnvname("MYSQL_ROOT_PASSWORD");
				k8s.setEnvalue(services.getPassword());
				k8s.setContainerPath("/var/lib/mysql");
			}else{
				k8s.setContainerPath("/usr/local/tomcat/webapps/ROOT");
				k8s.setContainerPort(8080);
				k8s.setEnvname("null");
				k8s.setEnvalue("null");
			}
			Integer id = 10000;
			id = services.getUid()+id;
			k8s.setDeployId(id.toString());
		
			//k8sService.addK8s(k8s);
			k8sService.delK8s(k8s);
			break;
		}
		
		servicesService.delServices(Integer.parseInt(uid));
		
		
		
		return "redirect:serviceget.action";
	}
	
	@RequestMapping("serviceget.action")
	public String  serviceget(HttpServletRequest request) throws Exception{
		//System.out.println(user);
		//return "forward:list.action";
		HttpSession session = request.getSession();
		session.removeAttribute("appversion");
		session.removeAttribute("appname");
		
		String uname = (String)session.getAttribute("name");
		List<Services> list = servicesService.selectServices(uname);
		
		for (Services services : list) {
			System.out.println(services.getUid()+"  "+services.getName()+"  "+
		services.getServicename()+"  "+services.getIpandport()+"  "+services.getAccount()+"  "+services.getPassword()+"  ");
		}
		
		request.setAttribute("ulist", list);
		//return "siteinfos";
		return "redirect:appget.action";
	}
	
	
////////////////////////APP cao zuo ========================
	
	@RequestMapping("appget.action")
	public String  appget(HttpServletRequest request) throws Exception{

		HttpSession session = request.getSession();
		session.removeAttribute("appversion");
		session.removeAttribute("appname");
		
		String uname = (String)session.getAttribute("name");
		List<Services> slist = servicesService.selectServices(uname);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@the list num is :"+slist.size());
		if(slist.size()>=3){
			session.setAttribute("buttonvalue", "disabled='disabled'");
			System.out.println("所添加的服务已经超过三个了");
		}else{
			
			session.setAttribute("buttonvalue", "");
			System.out.println("服务还未达到上限");
		}
		request.setAttribute("ulist", slist);
		session.setAttribute("servicelists", slist);
		
		
		List<App> lists = appService.selectAppName();
		request.setAttribute("appnames", lists);
		String name = "";
		String versions = "";
		
		for (App apps : lists) {
			System.out.println("app name is :"+apps.getAppname());
			name = apps.getAppname();
			break;
		}
		
		
		String appname = (String)session.getAttribute("appname");
		System.out.println("appname is :"+appname);
		if(appname == null){
			appname=name;
			
		}
		List<App> list = appService.selectAppInfos(appname);
		for (App app : list) {
			System.out.println(app.getUid()+"  "+app.getAppname()+"  "+app.getversions());	
			versions = app.getversions();
			break;
		}
		System.out.println("======================================appget is : "+ appname+"  "+versions);
		session.setAttribute("appname", appname);
		session.setAttribute("appversions", versions);
		request.setAttribute("appversion", list);
		return "siteinfos";
	}
	
	
	@RequestMapping("appversionsget.action")
	public String appversionsget(HttpServletRequest request) throws Exception {
		String appname = request.getParameter("appname");
		HttpSession session = request.getSession();
		String appversion = "";
		List<App> list = appService.selectAppInfos(appname);
		for (App app : list) {
			appversion = app.getversions();
			break;
		}
		String uname = (String)session.getAttribute("name");
		List<Services> slist = servicesService.selectServices(uname);
		request.setAttribute("ulist", slist);
		
		request.setAttribute("appversion", list);
		session.setAttribute("appname", appname);
		session.setAttribute("appversions", appversion);
		request.setAttribute("appselected", appname);
//		session.setAttribute("appselected", appname);
		List<App> lists = appService.selectAppName();
		request.setAttribute("appnames", lists);
		System.out.println("========================appversionget is :"+appname+"  "+appversion);
		return "siteinfos";
	}

	
	@RequestMapping("setappversions.action")
	public String  setappversions(HttpServletRequest request) throws Exception{
		String appversions = request.getParameter("appversion");
		HttpSession session = request.getSession();
		session.setAttribute("appversions",appversions);
		
		String appname = (String) session.getAttribute("appname");
		List<App> list = appService.selectAppInfos(appname);
		request.setAttribute("appversion", list);
		
		String uname = (String)session.getAttribute("name");
		List<Services> slist = servicesService.selectServices(uname);
		request.setAttribute("ulist", slist);
		
		request.setAttribute("appselected", appname);
//		session.setAttribute("appselected", appname);
		request.setAttribute("appversionsselected", session.getAttribute("appversions"));
//		session.setAttribute("appversionsselected", session.getAttribute("appversions"));
		List<App> lists = appService.selectAppName();
		request.setAttribute("appnames", lists);
		
		System.out.println("======================================setappversions is :"+session.getAttribute("appname")+" "+session.getAttribute("appversions"));
		
		return "siteinfos";
	}
	
	@RequestMapping("serviceinit.action")
	public String  serviceinit(HttpServletRequest request) throws Exception{
		int uid = 0;
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		Services service = new Services();
		
		List<Services> slist = servicesService.selectServices(name);
		System.out.println(slist.size());
		if(slist == null || slist.equals("") || slist.size() == 0){
			
			service.setName("test");
			servicesService.addServices(service);
			slist = servicesService.selectServices("test");
			for (Services services : slist) {
				uid = services.getUid();
			}
			servicesService.delServices(uid);
		}else{
			 slist = servicesService.selectServices(name);
			 for (Services services : slist) {
					uid = services.getUid();
				}
		}
		
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@the list num is :"+session.getAttribute("servicelists"));
		service.setName(name);
		service.setServiceversion((String) session.getAttribute("appversions"));
		service.setServicename((String) session.getAttribute("appname"));
		
		String[] getnodeips = k8sService.getnodeips();
		int n = getnodeips.length;
		int num = (int)((Math.random()*n+1))-1;
		String hostip = getnodeips[num].replace("'", "");
		int ports = uid + 10000 +1;
		String port = String.valueOf(ports);
		System.out.println(hostip+port);
		service.setIpandport(hostip+":"+port);
		service.setAccount("root");
		service.setPassword(getPasswd.passwd(16));
		servicesService.addServices(service);
		System.out.println("serviceinit :you choice is :"+session.getAttribute("appname")+" "+session.getAttribute("appversions"));

		return "redirect:appget.action";
	}
	
	
	////////////////////#########sshcommand#######################
	@RequestMapping("sshcommand.action")
	public String  sshcommand(HttpServletRequest request) throws Exception{

		String cmds = request.getParameter("command");
		List<String> results = sshcmdService.command(cmds);
		System.out.println("执行命令：命令如下: "+cmds);
		request.setAttribute("sshcmdinfos", results);
		request.setAttribute("command", cmds);
		
	
		return "sshcmdinfos";
	}
	
	
	@RequestMapping("getwebshellurl.action")
	public String  getwebshellurl(HttpServletRequest request) throws Exception{
		String uid = request.getParameter("uid");
		HttpSession session = request.getSession();
		K8s k8s = new K8s();
		//String uname = (String)session.getAttribute("name");
		List<Services> slist = servicesService.getServices(Integer.parseInt(uid));
		//k8s.setNamespaceName((String) session.getAttribute("name"));
		for (Services services : slist) {
			k8s.setAppname(services.getServicename());
			k8s.setNamespaceName(services.getName());
		}
		//k8sService.addK8s(k8s);
		//k8sService.delK8s(k8s);
		//System.out.println(k8sService.getnodeips());
		String webshellurl = k8sService.getWebShellUrl(k8s).toString();
		System.out.println("webshellurl is "+webshellurl);
		session.setAttribute("webshellurl", webshellurl);
		return "redirect:appget.action";
	}

	@RequestMapping("k8sinit.action")
	public String  k8sinit(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("name");
		List<Services> slist = servicesService.selectServices(uname);
		K8s k8s = new K8s();
		for (Services services : slist) {
			String strig = services.getIpandport();
			String[] ipandport=strig.split(":");
			
			k8s.setNamespaceName(uname);
			k8s.setAppname(services.getServicename());
			k8s.setReplicas(1);
			k8s.setHostIP(ipandport[0]);
			k8s.setHostPort(Integer.valueOf(ipandport[1]));
			String HostPath = "/data/NFS/services/"+services.getServicename()+"/"+uname+"/";
			k8s.setHostPath(HostPath);
			
			String imagename = "10.1.41.200:5000/"+services.getServicename()+"/"+services.getServicename()+":"+services.getServiceversion();
			k8s.setContainerImage(imagename);
			k8s.setCpu(1);
			k8s.setMem(1);
			if(services.getServicename().equals("httpd")){
				k8s.setContainerPort(80);
				k8s.setContainerPath("/usr/local/apache2/htdocs");
//				k8s.setContainerPath("/var/www/html");
				k8s.setEnvname("null");
				k8s.setEnvalue("null");
			}else if(services.getServicename().equals("mysql")){
				k8s.setContainerPort(3306);
				k8s.setEnvname("MYSQL_ROOT_PASSWORD");
				k8s.setEnvalue(services.getPassword());
				k8s.setContainerPath("/var/lib/mysql");
			}else if(services.getServicename().equals("tomcat")){
				k8s.setContainerPath("/usr/local/tomcat/webapps/ROOT");
				k8s.setContainerPort(8080);
				k8s.setEnvname("null");
				k8s.setEnvalue("null");
			}else {
				continue;
			}
			Integer id = 10000;
			id = services.getUid()+id;
			k8s.setDeployId(id.toString());
		
			k8sService.addK8s(k8s);
			//k8sService.delK8s(k8s);
		}
		//k8sService.delK8s(k8s);
		//System.out.println(k8sService.getnodeips());
		//System.out.println(k8sService.getWebShellUrl(k8s));
		return "redirect:appget.action";
	}
	
}
