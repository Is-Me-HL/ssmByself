/**   
* @Title: bookService.java 
* @Package club.hl.service 
* @Description: TODO
* @author HL
* @date 2018年12月6日 下午6:16:21 
* @version V1.0   
*/
package club.hl.service;

import java.util.List;

import club.hl.pojo.bookCustom;
import club.hl.pojo.bookQueryVo;

public interface bookService {

	// 书的查询列表
	public List<bookCustom> findBooksList(bookQueryVo bQueryVo)
			throws Exception;

	// 根据id查询商品信息
	/**
	 * 
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public bookCustom findBookById(Integer id) throws Exception;

	// 修改商品信息
	/**
	 * 
	 * @param id 修改商品的id
	 * @param bCustom
	 * @throws Exception
	 */
	public void updateBook(Integer id, bookCustom bCustom) throws Exception;
}
