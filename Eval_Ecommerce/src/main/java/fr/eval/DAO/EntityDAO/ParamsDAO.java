package fr.eval.DAO.EntityDAO;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eval.DAO.connexion.ConnexionBdd;
import fr.eval.entity.Params;
import fr.eval.security.keys.GenerateKey;

public class ParamsDAO {

	private Session session = null;
	private Params params = null;
	private final String ALGO = "AES";
	private final int KEYSIZE = 256;

	public Key getCleDeChiffrageCp() throws Exception {
		Transaction transaction = null;
		try {

			this.session = ConnexionBdd.getSession();
			this.params = this.session.find(Params.class, (long) 1);
			
			if (this.params == null) {
				this.params = new Params();
				Key key = GenerateKey.getKey(this.ALGO, this.KEYSIZE);
				transaction = this.session.beginTransaction();
				this.params.setCle_cryptage_cp(key.getEncoded());
				session.save(this.params);
				transaction.commit();
				return key;
			} else {
				Key key = GenerateKey.getKey(this.ALGO, this.KEYSIZE);
				transaction = this.session.beginTransaction();
				this.params.setCle_cryptage_cp(key.getEncoded());
				session.update(this.params);
				transaction.commit();
			}

		} catch (RollbackException e) {
			transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

		Key newkey = new SecretKeySpec(this.params.getCle_cryptage_cp(), ALGO);
		return newkey;

	}

	public Key getCleDeChiffrageMdp() throws Exception {
		Transaction transaction = null;
		try {

			this.session = ConnexionBdd.getSession();
			this.params = this.session.find(Params.class, (long) 1);

			if (this.params == null) {
				this.params = new Params();
				Key key = GenerateKey.getKey(this.ALGO, this.KEYSIZE);
				transaction = this.session.beginTransaction();
				this.params.setCle_cryptage_mdp(key.getEncoded());
				session.save(this.params);
				transaction.commit();
				return key;
			} else {
				Key key = GenerateKey.getKey(this.ALGO, this.KEYSIZE);
				transaction = this.session.beginTransaction();
				this.params.setCle_cryptage_mdp(key.getEncoded());
				session.update(this.params);
				transaction.commit();
				return key;
			}

		} catch (RollbackException e) {
			transaction.rollback();
		} finally {
			this.closeSession(this.session);
		}

		Key newkey = new SecretKeySpec(this.params.getCle_cryptage_mdp(), ALGO);
		return newkey;

	}

	public void closeSession(Session session) throws Exception {
		if (session != null && session.isOpen()) {
			session.close();
		}

	}

}
