package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;
import model.Disciplina;
import model.Matricula;

public class MatriculaDao implements IObjDao<Matricula> {

	private SessionFactory sf;

	public MatriculaDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Matricula t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();

	}

	@Override
	public void modifica(Matricula t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();

	}

	@Override
	public void remove(Matricula t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Matricula> lista() {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ra, nome, email, posivaoVestibular ");
		buffer.append("FROM aluno ");
		buffer.append("ORDER BY posivaoVestibular");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Matricula m = new Matricula();
			m.setAluno((Aluno) obj[0]);
			m.setDisciplina((Disciplina) obj[1]);
			m.setAno((int) obj[2]);
			m.setSemestre((int) obj[2]);

			matriculas.add(m);
		}

		return matriculas;
	}

}
