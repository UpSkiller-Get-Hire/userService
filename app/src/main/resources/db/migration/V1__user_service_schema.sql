CREATE TABLE user_profile (
                              id BIGSERIAL PRIMARY KEY,
                              user_id VARCHAR(100) NOT NULL UNIQUE,

                              full_name VARCHAR(150),
                              profile_picture_url TEXT,

                              country VARCHAR(100),
                              state VARCHAR(100),
                              city VARCHAR(100),

                              profile_status VARCHAR(30) NOT NULL DEFAULT 'INCOMPLETE',

                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE education (
                           id BIGSERIAL PRIMARY KEY,
                           user_id VARCHAR(100) NOT NULL,

                           education_level VARCHAR(30) NOT NULL,
                           institution_name VARCHAR(200) NOT NULL,
                           field_of_study VARCHAR(150),

                           start_year INT,
                           end_year INT,
                           currently_studying BOOLEAN DEFAULT FALSE,

                           CONSTRAINT fk_education_user
                               FOREIGN KEY (user_id)
                                   REFERENCES user_profile(user_id)
                                   ON DELETE CASCADE
);

CREATE TABLE job_preference (
                                id BIGSERIAL PRIMARY KEY,
                                user_id VARCHAR(100) NOT NULL UNIQUE,

                                job_category VARCHAR(50) NOT NULL,
                                job_type VARCHAR(30) NOT NULL,
                                work_mode VARCHAR(30) NOT NULL,

                                experience_level VARCHAR(30),
                                availability VARCHAR(50),

                                CONSTRAINT fk_job_pref_user
                                    FOREIGN KEY (user_id)
                                        REFERENCES user_profile(user_id)
                                        ON DELETE CASCADE
);

CREATE TABLE preferred_role (
                                id BIGSERIAL PRIMARY KEY,
                                job_preference_id BIGINT NOT NULL,
                                role_name VARCHAR(100) NOT NULL,

                                CONSTRAINT fk_pref_role_job_pref
                                    FOREIGN KEY (job_preference_id)
                                        REFERENCES job_preference(id)
                                        ON DELETE CASCADE
);

CREATE TABLE user_cv (
                         id BIGSERIAL PRIMARY KEY,
                         user_id VARCHAR(100) NOT NULL UNIQUE,

                         cv_url TEXT NOT NULL,
                         uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         CONSTRAINT fk_cv_user
                             FOREIGN KEY (user_id)
                                 REFERENCES user_profile(user_id)
                                 ON DELETE CASCADE
);
