
asadmin create-auth-realm \
--classname=com.cun.enterprise.security.auth.realm.jdbc.JDBCRealm \
--property jaas-context=jdbcRealm\
:datasource-jndi=java\\:global/jdbc/Cinuja\         no me escapa los : y el comando no funciona en esta entrega crear el realm a mano
:user-table=USUARIO\
:user-name-column=NICK\
:password-column=CONTRASENA\
:group-table=USUARIO\
:group-name-column=ROL\
:group-table-user-name-column=USUARIO\
:digest-algorithm=none \
cinuja

asadmin create-auth-realm --classname com.cun.enterprise.security.auth.realm.jdbc.JDBCRealm --property jaas-context=jdbcRealm:datasource-jndi=java\\:global/jdbc/Cinuja:user-table=USUARIO:user-name-column=NICK:password-column=CONTRASENA:group-table=USUARIO:group-name-column=ROL:group-table-user-name-column=USUARIO:digest-algorithm=none cinuja
