package tw.com.reinbach.wonderful.controller;

import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.reinbach.wonderful.member.bean.MemberBean;
import tw.com.reinbach.wonderful.member.service.MemberService;
import tw.com.reinbach.wonderful.tools.IDGenerator;

@Controller
@RequestMapping(path = { "/member.controller" })
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private IDGenerator idGenerator;

	@RequestMapping(value = "/Insert", method = { RequestMethod.POST }, produces = { "application/json; charset=UTF8" })
	@ResponseBody
	public String processInsert(MemberBean memberBean, Model model) {
		if (memberBean != null) {
			memberBean.setMemID(idGenerator.getMemberID());
			memberBean.setRegDate(new Date(System.currentTimeMillis()));
			memberService.insert(memberBean);
			JSONArray arry = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("MemberID", memberBean.getMemID());
			obj.put("Name", memberBean.getName());
			return arry.put(obj).toString();
		}
		return null;
	}

	@RequestMapping(value = "/Query", method = { RequestMethod.POST }, produces = { "application/json;charset=UTF8" })
	@ResponseBody
	public String processQuery(MemberBean memberBean, Model model) {
		List<MemberBean> list = null;
		JSONArray array = new JSONArray();

		if (memberBean.getEmail().trim().length() == 0 || memberService.select(memberBean.getEmail()) != null) {
			list = memberService.select(memberBean);

			for (int i = 0; i < list.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("MemID", list.get(i).getMemID());
				obj.put("Name", list.get(i).getName());
				obj.put("Addr", list.get(i).getAddr());
				obj.put("Cell", list.get(i).getCell());
				obj.put("Email", list.get(i).getEmail());
				obj.put("RegDate", list.get(i).getRegDate());

				array.put(obj);
			}
		}
		return array.toString();
	}

	@RequestMapping(value = "/QueryRepost", method = { RequestMethod.POST }, produces = {
			"application/json;charset=UTF8" })
	@ResponseBody
	public String processQueryRepost(String email, Model model) {
		System.out.println(email);
		MemberBean memberBean = memberService.select(email);
		JSONArray array = new JSONArray();
		if (email.trim().length() == 0 || memberBean != null) {
			JSONObject obj = new JSONObject();
			obj.put("MemID", memberBean.getMemID());
			obj.put("Pwd", memberBean.getPwd());
			obj.put("Name", memberBean.getName());
			obj.put("Addr", memberBean.getAddr());
			obj.put("Cell", memberBean.getCell());
			obj.put("Email", memberBean.getEmail());
			obj.put("RegDate", memberBean.getRegDate());
			array.put(obj);
		}
		return array.toString();
	}

	@RequestMapping(value = "/Update", method = { RequestMethod.POST }, produces = "application/json;charset=UTF8")
	@ResponseBody
	public String processUpdate(MemberBean memberBean, Model model) {
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("MemID", memberBean.getMemID());
		obj.put("Email", memberBean.getEmail());
		memberService.update(memberBean);
		array.put(obj);
		return array.toString();
	}

}
