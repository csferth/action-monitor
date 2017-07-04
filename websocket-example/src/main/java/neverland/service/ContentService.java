package neverland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neverland.dao.IContentDAO;
import neverland.entity.Content;

@Service
public class ContentService implements IContentService {

	@Autowired
	private IContentDAO contentDAO;

	public List<Content> getAllContent() {
		return contentDAO.getAllContent();
	}

	public Content getContentById(int contentId) {
		return contentDAO.getContentById(contentId);
	}

	public synchronized boolean addContent(Content content) {
		boolean result = false;
		if (!contentDAO.contentExists(content.getData())) {
			contentDAO.addContent(content);
			result = true;
		}
		return result;
	}

	public void updateContent(Content content) {
		contentDAO.updateContent(content);
	}

	public void deleteContent(int contentId) {
		contentDAO.deleteContent(contentId);
	}
	
	
}
