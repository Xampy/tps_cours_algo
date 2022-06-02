package com.xampy.projetAlgoSpring.unit.service;

import com.xampy.projetAlgoSpring.dao.ContactRepositoryInterface;
import com.xampy.projetAlgoSpring.model.Contact;
import com.xampy.projetAlgoSpring.service.ContactService;
import com.xampy.projetAlgoSpring.service.ContactServiceInterface;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.once;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @Mock
    private ContactRepositoryInterface contactRepository;

    private ContactServiceInterface contactService;

    @BeforeEach
    void setup() {
         this.contactService = new ContactService(contactRepository);
    }


    @Test
    void saveContact() {
        //Given
        String nom = "nom";
        String prenoms = "prenoms";
        String sexe = "sexe";
        String telephone = "telephone";
        String email = "email";
        Contact c = new Contact(1L, nom, prenoms, sexe, telephone, email);

        when(contactRepository.save(any())).thenReturn(c);
        //When
        Contact savedContact = this.contactService.saveContact(c);

        //Then
        verify(contactRepository, times(1)).save(any());
        assertEquals(savedContact.getNom(), c.getNom());
    }

    @Test
    void listContact() {
        //Given
        String nom = "nom";
        String prenoms = "prenoms";
        String sexe = "sexe";
        String telephone = "telephone";
        String email = "email";
        Contact c = new Contact(null, nom, prenoms, sexe, telephone, email);
        this.contactService.saveContact(c);


        when(contactRepository.findAll(any(Pageable.class)))
                .thenReturn(contactPage);
        //When
        List<Contact> contactsList = this.contactService.listContact(1);

        //Then
        assertEquals(1, contactsList.size());
        assertEquals(nom, contactsList.get(0).getNom());
    }

    @Test
    void updateContact() {
    }

    @Test
    void getContact() {
    }

    @Test
    void deleteContact() {
    }

    private Page<Contact> contactPage = new Page<Contact>() {
        @Override
        public int getTotalPages() {
            return 0;
        }

        @Override
        public long getTotalElements() {
            return 0;
        }

        @Override
        public <U> Page<U> map(Function<? super Contact, ? extends U> converter) {
            return null;
        }

        @Override
        public int getNumber() {
            return 0;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public int getNumberOfElements() {
            return 0;
        }

        @Override
        public List<Contact> getContent() {
            String nom = "nom";
            String prenoms = "prenoms";
            String sexe = "sexe";
            String telephone = "telephone";
            String email = "email";
            Contact c = new Contact(null, nom, prenoms, sexe, telephone, email);
            return List.of(c);
        }

        @Override
        public boolean hasContent() {
            return false;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Pageable nextPageable() {
            return null;
        }

        @Override
        public Pageable previousPageable() {
            return null;
        }

        @Override
        public Iterator<Contact> iterator() {
            return null;
        }
    };
}