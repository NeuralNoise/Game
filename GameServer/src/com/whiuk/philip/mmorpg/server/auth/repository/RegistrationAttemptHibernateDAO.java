package com.whiuk.philip.mmorpg.server.auth.repository;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whiuk.philip.mmorpg.server.hibernate.HibernateDAO;
import com.whiuk.philip.mmorpg.server.hibernate.HibernateUtils;
import com.whiuk.philip.mmorpg.serverShared.RegistrationAttempt;

/**
 * Hibernate Registration Attempt Data Access Object.
 * @author Philip Whitehouse
 */
@Repository
public class RegistrationAttemptHibernateDAO
        extends HibernateDAO<RegistrationAttempt, Long>
        implements RegistrationAttemptDAO {
    @Override
    public final RegistrationAttempt findByID(final Long id) {
        RegistrationAttempt registrationAttempt = null;
        String sql = "SELECT la FROM RegistrationAttempt ra WHERE ra.id = :id";
        Query query = HibernateUtils.getSession().createQuery(sql)
                .setParameter("id", id);
        registrationAttempt = findOne(query);
        return registrationAttempt;
    }
}
