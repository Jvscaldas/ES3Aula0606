package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Disciplina;

public class DisciplinaDao implements IObjDao<Disciplina> {

	private SessionFactory sf;

	public DisciplinaDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Disciplina t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();

	}

	@Override
	public void modifica(Disciplina t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();

	}

	@Override
	public void remove(Disciplina t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Disciplina> lista() {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ra, nome, email, posivaoVestibular ");
		buffer.append("FROM aluno ");
		buffer.append("ORDER BY posivaoVestibular");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Disciplina d = new Disciplina();
			d.setCodigo_disc((int) obj[0]);
			d.setNome_disc(obj[1].toString());
			d.setCarga_horaria((int) obj[2]);

			disciplinas.add(d);
		}

		return disciplinas;
	}

}
