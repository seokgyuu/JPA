package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import domain.Content;

@Repository
public class ContentRepository {
	
	private static Map<Integer , Content> contents = new HashMap<>();
	private static int sequence = 0;
	
	public void save(Content content) {
		content.setId(++sequence);
        contents.put(content.getId(), content);
	}
	
	public void edit(int id, Content content) {
		contents.put(id,content);
	}
	
	public void delete(int id) {
		contents.remove(id);
	}
	
	public List<Content> findAll() {
		return new ArrayList<>(contents.values());
	}
	
	public Content findById(int id) {
		return contents.get(id);
	}
}
