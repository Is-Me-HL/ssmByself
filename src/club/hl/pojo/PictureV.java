/**   
* @Title: PictureV.java 
* @Package club.hl.pojo 
* @Description: TODO
* @author HL
* @date 2018年12月14日 下午8:05:47 
* @version V1.0   
*/
package club.hl.pojo;

public class PictureV {// 该类便于PictureC类相关查询使用
	private Picture picture;
	private PictureC pictureC;
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public PictureC getPictureC() {
		return pictureC;
	}
	public void setPictureC(PictureC pictureC) {
		this.pictureC = pictureC;
	}
}
