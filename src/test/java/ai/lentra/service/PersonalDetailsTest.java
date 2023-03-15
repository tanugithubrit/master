package ai.lentra.service;

import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.repository.PersonalDetailsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PersonalDetailsTest {

    @Mock
    private PersonalDetailsRepository personalDetailsRepository;

    @InjectMocks
    private PersonalDetailServiceImpl personalDetailsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddPersonalDetail() throws DuplicateResourceException, InvalidInputException {
        // Arrange
        PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
        personalDetailsDTO.setFirstName("John");
        personalDetailsDTO.setLastName("Doe");
        personalDetailsDTO.setBirthDate("01/01/2000");
        personalDetailsDTO.setReligion("English");
        personalDetailsDTO.setSuffix("MM");
        personalDetailsDTO.setLoanTakenEarlier(true);
        personalDetailsDTO.setIncome(new BigDecimal(77372737));
        personalDetailsDTO.setCitizenship("INDIAN");
        Long applicantId = 123L;
        personalDetailsDTO.setDateInspected("01/01/2020");

        when(personalDetailsRepository.findByApplicantId(anyLong())).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> response = personalDetailsController.addPersonalDetail(personalDetailsDTO, applicantId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Personal Details added Successfully ", ((ResponseDTO)response.getBody()).getMessage());
        assertEquals("CREATED", ((ResponseDTO)response.getBody()).getStatus().toString());

        // Verify
        ArgumentCaptor<PersonalDetails> argumentCaptor = ArgumentCaptor.forClass(PersonalDetails.class);
        verify(personalDetailsRepository, times(1)).save(argumentCaptor.capture());
        PersonalDetails savedDetails = argumentCaptor.getValue();
        assertEquals("John", savedDetails.getFirstName());
        assertEquals("Doe", savedDetails.getLastName());
        assertEquals(applicantId, savedDetails.getApplicantId());
        assertEquals(23, savedDetails.getAge());
    }
    @Test
    void testUpdatePersonalDetail() throws DuplicateResourceException, InvalidInputException, ResourceNotFoundException {
        // Arrange
        PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
        personalDetailsDTO.setFirstName("John");
        personalDetailsDTO.setLastName("Doe");
        personalDetailsDTO.setBirthDate("01/01/2000");
        personalDetailsDTO.setAge(23);
        personalDetailsDTO.setApplicantId(123L);
        personalDetailsDTO.setReligion("English");
        personalDetailsDTO.setSuffix("MM");
        personalDetailsDTO.setLoanTakenEarlier(true);
        personalDetailsDTO.setIncome(new BigDecimal(77372737));
        personalDetailsDTO.setCitizenship("INDIAN");
        Long applicantId = 123L;
        personalDetailsDTO.setDateInspected("01/01/2020");
        ObjectMapper objectMapper= new ObjectMapper();
        PersonalDetails personalDetailsEntity =objectMapper.convertValue(personalDetailsDTO,PersonalDetails.class);

        when(personalDetailsRepository.findByApplicantId(anyLong())).thenReturn(Optional.ofNullable(personalDetailsEntity));
        System.out.println(personalDetailsEntity);
        // Act
        ResponseEntity<?> response = personalDetailsController.updatePersonalDetail(personalDetailsDTO, applicantId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PersonalDetails updated Successfully", ((ResponseDTO)response.getBody()).getMessage().toString());
        assertEquals("Success", ((ResponseDTO)response.getBody()).getStatus());

        // Verify
        ArgumentCaptor<PersonalDetails> argumentCaptor = ArgumentCaptor.forClass(PersonalDetails.class);
        verify(personalDetailsRepository, times(1)).save(argumentCaptor.capture());
        PersonalDetails savedDetails = argumentCaptor.getValue();
        assertEquals("John", savedDetails.getFirstName());
        assertEquals("Doe", savedDetails.getLastName());
        assertEquals(applicantId, savedDetails.getApplicantId());
        assertEquals(23, savedDetails.getAge());
    }


}
