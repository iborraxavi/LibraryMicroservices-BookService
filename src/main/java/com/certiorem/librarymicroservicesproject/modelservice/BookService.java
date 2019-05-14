package com.certiorem.librarymicroservicesproject.modelservice;

import java.util.List;

public interface BookService {
	
	public Object createUpdateBook(Object book);
	
	public Object getBook(Integer id);
	
	public void deleteBook(Integer id);
	
	public List<Object> getAllBooks();
	
	public List<Object> getBooksByEditorialId(Integer editorialId);
	
	public List<Object> getBooksByGenreId(Integer genreId);

}
