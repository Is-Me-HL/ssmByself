/**   
* @Title: bookController.java 
* @Package club.hl.controller 
* @Description: TODO
* @author HL
* @date 2018年12月6日 下午6:58:17 
* @version V1.0   
*/
package club.hl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import club.hl.pojo.bookCustom;
import club.hl.pojo.bookQueryVo;
import club.hl.service.bookService;

@Controller
@RequestMapping("/books")
public class bookController {

	@Autowired
	private bookService bService;
	@RequestMapping("/queryBook")
	public ModelAndView queryItems(HttpServletRequest request,bookQueryVo bQueryVo) throws Exception {
		List<bookCustom> list = bService.findBooksList(bQueryVo);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookList", list);
		modelAndView.setViewName("book/a");
		return modelAndView;
	}
	// 商品信息修改页面的展示
	@RequestMapping(value="/editBook",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView editBook(@RequestParam(value="id",required=true)Integer book_id) throws Exception {
		// 调用service根据商品id查询商品信息
		bookCustom bCustom=bService.findBookById(book_id);
		ModelAndView modelAndView = new ModelAndView();
		/*List<bookCustom>list=new ArrayList<>();
		list.add(bCustom);*/
		modelAndView.addObject("bookCustom", bCustom);
		modelAndView.setViewName("book/editBook");
		return modelAndView;
	}
	
	//商品修改的提交
	/*@RequestMapping("/editBookSubmit")
	public ModelAndView editBookSubmit() throws Exception {
		//调用service更新商品信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}*/
	@RequestMapping("/editBookSubmit")
	/**
	 * @Validated bookCustom bCustom,BindingResult bindingResult
	 * @Validated和BindingResult bindingResult是配套使用的
	 * @Validated表示需要校验，BindingResult bindingResult表示对校验后的错误信息进行接收
	 * @ModelAttribute:用于数据回显，springMvc默认回显pojo数据，以pojo的类名首字母小写作为key，存入request，如类名为TestBook，request中就可以取到key为testBook的pojo属性值直接进行回显
	 * */
	public String editBookSubmit(Model model,HttpServletRequest request,Integer id,
			/*@ModelAttribute("bCustom")*/@Validated bookCustom bCustom,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError allError:allErrors) {
				System.out.println(allError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			System.out.println("editBookSubmit________"+model);
			return "book/editBook";
		}
		bService.updateBook(id, bCustom);
		return "success";
	}
}
