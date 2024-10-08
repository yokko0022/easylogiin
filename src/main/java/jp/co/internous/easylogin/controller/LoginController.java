package jp.co.internous.easylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.easylogin.model.domain.MstUser;
import jp.co.internous.easylogin.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/easylogin")
public class LoginController {
	@Autowired
	private MstUserMapper userMapper;
	//↑「@Autowired」アノテーション宣言されたオブジェクトはSpringBootが自動的にインスタンス化する。	//↑最重要ポイント！！！↑

	@GetMapping("/")
	public String index() {
		return "index";
	}

	//@GetMapping("/login")
	@GetMapping("login")
	public String login(String userName, String password, Model model) {
		//System.out.println("userName:"+ userName);
		//System.out.println("password:"+ password);
		//System.exit(0);
		MstUser user = userMapper.findByUserNameAndPassword(userName, password);
		//「mapper」を使用し、データベースにアクセスする。※「MstUserMapper」参照
		System.out.println("userName::::"+userName);
		if (user == null) {
			model.addAttribute("message", "ゲストさん、ようこそ！");
			//model.addAttribute("message", user.getClass().getName() + "さん、if前！");
		} else {
			//System.out.println("message", user.getFullName() + "さん、ようこそ！");
			model.addAttribute("message", user.getFullName() + "さん、ようこそ！");

		}

		return "login";		//login.htmlに遷移させる

	}
}
