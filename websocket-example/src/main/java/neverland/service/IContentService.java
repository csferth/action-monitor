package neverland.service;

import java.util.List;

import neverland.entity.Content;

public interface IContentService {

	List<Content> getAllContent();

    Content getContentById(int contentId);

    boolean addContent(Content content);

    void updateContent(Content content);

    void deleteContent(int contentId);
}
