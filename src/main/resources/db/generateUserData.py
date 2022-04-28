import random
import bcrypt
from faker import Faker


def app():
    sql_query11 = "insert into usr (id, username, first_name, last_name, middle_name, email, birthday, password) "
    sql_query21 = "insert into user_role (user_id, roles) "
    query_nextval = "nextval('hibernate_sequence')"
    query_currval = "currval('hibernate_sequence')"

    roles = ["INSTRUCTOR", "MANAGER", "STUDENT"]
    locale_list = ['ru-RU']
    faker = Faker(locale_list)
    Faker.seed(random.randint(0, 100))
    random1 = random.Random()

    for id in range(20):
        name = faker.name().split()
        first_name = name[0]
        last_name = name[1]
        middle_name = name[2]
        email = faker.ascii_email()
        username = email.split('@')[0]
        password = username
        birthday = faker.date()
        encrypt_password = bcrypt.hashpw(password.encode(), bcrypt.gensalt(8))
        role = roles[random1.randint(0, len(roles)) - 1]

        sql_query12 = f"values({query_nextval}, '{username}', '{first_name}', '{last_name}', '{middle_name}', " \
                      f"'{email}', '{birthday}', '{encrypt_password.decode()}');"
        sql_query22 = f"values({query_currval}, '{role}');"

        print(sql_query11)
        print(sql_query12)
        print(sql_query21)
        print(sql_query22)
        print()


if __name__ == '__main__':
    app()
