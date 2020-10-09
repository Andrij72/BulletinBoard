INSERT INTO public.posts (id, anons, filename, full_text, rg_data, title, user_id)
VALUES (2,
        'ИТ-архитектор – это центральный персонаж при создании информационных систем. Именно от архитектора зависит, ' ||
        'состоится ли проект, заработает ли на этом проекте компания и ты просто не имеешь права подвести проектную ' ||
        'команду.', 132587, 'Будущий джава-архитектор', '2020-10-09', 'Java developer', 1);
INSERT INTO public.posts (id, anons, filename, full_text, rg_data, title, user_id)
VALUES (1, 'test test test test', 132585, 'Будущий джава-архитектор', '2020-10-09', 'Senjor Java Dev', 1);



INSERT INTO public.usr (id, email, first_name, last_name, password)
VALUES (2, 'b@gmail.com', 'Ivan', 'Lomachenko', '$2a$10$rcbmDE/uaIblG11V8hIX6uiVCNFzLfqY7ccK4Zm/qjl00jOuPNC1m');
INSERT INTO public.usr (id, email, first_name, last_name, password)
VALUES (3, 'c@gmail.com', 's', 's', '$2a$10$3SDrYagQbVFuxGXtLuzVDu6gkQ1nC8i8ffXbuMYeGPl7ENG4AnQ.O');
INSERT INTO public.usr (id, email, first_name, last_name, password)
VALUES (1, 'a@gmail.com', 'Andrej', 'Kulynych', '$2a$10$3SDrYagQbVFuxGXtLuzVDu6gkQ1nC8i8ffXbuMYeGPl7ENG4AnQ.O');


INSERT INTO public.role (id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO public.role (id, name)
VALUES (2, 'ROLE_USER');

INSERT INTO public.users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO public.users_roles (user_id, role_id)
VALUES (2, 2);