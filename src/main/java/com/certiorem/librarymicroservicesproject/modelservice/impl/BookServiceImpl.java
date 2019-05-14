package com.certiorem.librarymicroservicesproject.modelservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.certiorem.librarymicroservicesproject.constants.BookPathConstants;
import com.certiorem.librarymicroservicesproject.constants.DatabasePathConstants;
import com.certiorem.librarymicroservicesproject.model.bookmodel.Book;
import com.certiorem.librarymicroservicesproject.modelservice.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book createUpdateBook(Book book) {
		ResponseEntity<Book> responseEntity = new RestTemplate().postForEntity(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_SAVE, book, Book.class);
		return responseEntity.getBody();
	}

	@Override
	public void deleteBook(Integer bookId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_ID_PARAM_NAME, bookId);

		new RestTemplate().delete(DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_DELETE
				+ BookPathConstants.BOOK_SERVICE_ID_PARAM, uriVariables);
	}

	@Override
	public Book getBook(Integer bookId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_ID_PARAM_NAME, bookId);

		ResponseEntity<Book> responseEntity = new RestTemplate()
				.getForEntity(DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_READ
						+ BookPathConstants.BOOK_SERVICE_ID_PARAM, Book.class, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public List<Book> getAllBooks() {
		ResponseEntity<List<Book>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_ALL_BOOKS, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Book>>() {
				});
		return response.getBody();
	}

	@Override
	public List<Book> getBooksByEditorialId(Integer editorialId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_EDITORIAL_ID_PARAM_NAME, editorialId);
		ResponseEntity<List<Book>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_GET_BY_EDITORIAL
						+ BookPathConstants.BOOK_SERVICE_EDITORIAL_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
				}, uriVariables);
		return response.getBody();
	}

	@Override
	public List<Book> getBooksByGenreId(Integer bookGenreId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_GENRE_ID_PARAM_NAME, bookGenreId);
		ResponseEntity<List<Book>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_GET_BY_GENRE
						+ BookPathConstants.BOOK_SERVICE_GENRE_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
				}, uriVariables);
		return response.getBody();
	}

}
