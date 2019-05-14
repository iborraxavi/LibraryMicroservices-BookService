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
import com.certiorem.librarymicroservicesproject.modelservice.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Object createUpdateBook(Object book) {
		ResponseEntity<Object> responseEntity = new RestTemplate().postForEntity(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_SAVE, book, Object.class);
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
	public Object getBook(Integer bookId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_ID_PARAM_NAME, bookId);

		ResponseEntity<Object> responseEntity = new RestTemplate()
				.getForEntity(DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_READ
						+ BookPathConstants.BOOK_SERVICE_ID_PARAM, Object.class, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public List<Object> getAllBooks() {
		ResponseEntity<List<Object>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_ALL_BOOKS, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Object>>() {
				});
		return response.getBody();
	}

	@Override
	public List<Object> getBooksByEditorialId(Integer editorialId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_EDITORIAL_ID_PARAM_NAME, editorialId);
		ResponseEntity<List<Object>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_GET_BY_EDITORIAL
						+ BookPathConstants.BOOK_SERVICE_EDITORIAL_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {
				}, uriVariables);
		return response.getBody();
	}

	@Override
	public List<Object> getBooksByGenreId(Integer bookGenreId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(BookPathConstants.BOOK_SERVICE_GENRE_ID_PARAM_NAME, bookGenreId);
		ResponseEntity<List<Object>> response = new RestTemplate().exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + BookPathConstants.BOOK_SERVICE_GET_BY_GENRE
						+ BookPathConstants.BOOK_SERVICE_GENRE_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {
				}, uriVariables);
		return response.getBody();
	}

}
