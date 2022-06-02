package com.xampy.projetAlgoSpring.dao;

import com.xampy.projetAlgoSpring.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositoryInterface extends JpaRepository<Contact, Long> {
}
