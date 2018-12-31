package club.hl.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class book {
    private Integer id;

    @Size(min=1,max=10,message="{book.bookname.size.error}")
    private String bookname;

    @NotEmpty(message="{book.comefrom.isNull}")
    private String comefrom;

    private String author;

    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom == null ? null : comefrom.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "book [id=" + id + ", bookname=" + bookname + ", comefrom="
				+ comefrom + ", author=" + author + ", price=" + price + "]";
	}
}