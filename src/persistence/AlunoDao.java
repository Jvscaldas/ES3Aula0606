package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;

public class AlunoDao implements IObjDao<Aluno> {

	private SessionFactory sf;

	public AlunoDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Aluno t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(t);
		transaction.commit();

	}

	@Override
	public void modifica(Aluno t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(t);
		transaction.commit();

	}

	@Override
	public void remove(Aluno t) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(t);
		transaction.commit();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> lista() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ra, nome, email, posivaoVestibular ");
		buffer.append("FROM aluno ");
		buffer.append("ORDER BY posivaoVestibular");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Aluno al = new Aluno();
			al.setRa(obj[0].toString());
			al.setNome(obj[1].toString());
			al.setEmail(obj[2].toString());
			al.setPosicaoVestibular((int) obj[3]);

			alunos.add(al);
		}

		return alunos;
	}

}
