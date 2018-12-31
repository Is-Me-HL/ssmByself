package club.hl.service.impl;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import club.hl.mapper.bookMapper;
import club.hl.mapper.bookMapperCustom;
import club.hl.pojo.book;
import club.hl.pojo.bookCustom;
import club.hl.pojo.bookQueryVo;
import club.hl.service.bookService;

/**
 *   
 * 
 * @Title: bookServiceImpl.java 
 * @Package  
 * @Description: TODO
 * @author HL
 * @date 2018年12月6日 下午6:19:02 
 * @version V1.0   
 */

public class bookServiceImpl implements bookService {

	@Autowired
	private bookMapperCustom bMapperCustom;

	@Autowired
	private bookMapper bMapper;
	@Override
	public List<bookCustom> findBooksList(bookQueryVo bQueryVo)
			throws Exception {
		return bMapperCustom.findBooksList(bQueryVo);
	}

	@Override
	public bookCustom findBookById(Integer id) throws Exception {
		// return (bookCustom) bMapper.selectByPrimaryKey(id);
		book b = bMapper.selectByPrimaryKey(id);
		// 该出可能需要对查询到的商品信息进行业务上的其他处理
		bookCustom bCustom = new bookCustom();
		// 使用BeanUtils将book对象的属性值复制到bCustom
		BeanUtils.copyProperties(b, bCustom);
		return bCustom;
	}

	@Override
	public void updateBook(Integer id, bookCustom bCustom) throws Exception {
		// 添加校验，通常在Service接口对关键字进行校验，如校验id是否为空，如果为空抛出异常
		bCustom.setId(id);
		bMapper.updateByPrimaryKeySelective(bCustom);
	}

}
