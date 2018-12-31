package club.hl.mapper;

import java.util.List;

import club.hl.pojo.bookCustom;
import club.hl.pojo.bookQueryVo;

public interface bookMapperCustom {
	// 书的查询列表
	public List<bookCustom> findBooksList(bookQueryVo bQueryVo)throws Exception;
}