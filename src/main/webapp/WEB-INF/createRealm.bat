
asadmin delete-auth-realm cinuja

asadmin create-auth-realm ^
--classname=com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm ^
--property jaas-context=jdbcRealm^
:datasource-jndi=java\:global/jdbc/Cinuja^
:user-table=USUARIO^
:user-name-column=NICK^
:password-column=CONTRASENA^
:group-table=USUARIO^
:group-name-column=ROL^
:group-table-user-name-column=USUARIO^
:digest-algorithm=none ^
cinuja

REM asadmin create-auth-realm --classname com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm --property jaas-context=jdbcRealm:datasource-jndi=java\\:global/jdbc/Cinuja:user-table=USUARIO:user-name-column=NICK:password-column=CONTRASENA:group-table=USUARIO:group-name-column=ROL:group-table-user-name-column=USUARIO:digest-algorithm=none cinuja
