package neverland.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neverland.entity.Content;

@Transactional
@Repository
public class ContentDAO implements IContentDAO {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Content> getAllContent() {
		String hql = "FROM Content as cl ORDER BY cl.contentId";
		return (List<Content>) entityManager.createQuery(hql).getResultList();
	}

	public Content getContentById(int contentId) {
		return entityManager.find(Content.class, contentId);
	}

	public void addContent(Content content) {
		entityManager.persist(content);
	}

	public void updateContent(Content content) {
		Content cont = getContentById(content.getContentId());
		cont.setData(content.getData());
		entityManager.flush();
	}

	public void deleteContent(int contentId) {
		entityManager.remove(getContentById(contentId));
		
	}

	public boolean contentExists(String data) {
		String hql = "FROM Content as cl WHERE cl.data = ?";
		int count = entityManager.createQuery(hql).setParameter(1, data).getResultList().size();
		return count > 0 ? true : false;
	}
}
