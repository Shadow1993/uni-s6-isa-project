insert into application_user (id, is_active, created_at, email, password) values (1, true, '2025-07-28 14:28:14.789456', 'admin@example.com', '$2a$04$HL7jOESQVol0ntulIUN8UuNbfvtRGYcB.e5nRb/vR5OS6Gk2sekBi') on duplicate key update id=id;

insert into role (id, is_active, created_at, name) values (1, true, '2025-09-24 16:10:44.433166', 'ADMIN') on duplicate key update id=id;
insert into role (id, is_active, created_at, name) values (2, false, '2025-05-22 19:27:48.463318', 'USER') on duplicate key update id=id;

insert into assigned_role (id, is_active, created_at, role_id, user_id) values(1, true, '2026-05-07 12:29:36.495915', 1, 1) on duplicate key update id=id;