package neverland.dao;

import java.util.List;

import neverland.entity.Content;

public interface IContentDAO {

	List<Content> getAllContent();

	Content getContentById(int contentId);

    void addContent(Content content);

    void updateContent(Content content);

    void deleteContent(int contentId);

	boolean contentExists(String data);
}
