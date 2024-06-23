package br.com.iago.restap.unitTests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.iago.restap.dataVo.PersonVo;
import br.com.iago.restap.mapper.DozzerMapper;
import br.com.iago.restap.model.Person;


public class DozerConverterTest {
    
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

//    @Test
//    public void parseEntityToVOTest() {
//    	PersonVO output = DozzerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
//        assertEquals(Long.valueOf(0L), output.getId());
//        assertEquals("First Name Test0", output.getName());
//        assertEquals("Last Name Test0", output.getLastname());
//        assertEquals("Addres Test0", output.getAddress());
//        assertEquals("Male", output.getGender());
//    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVo> outputList = DozzerMapper.parseListObjects(inputObject.mockEntityList(), PersonVo.class);
        PersonVo outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        PersonVo outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        PersonVo outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozzerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("Last Name Test0", output.getLastname());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozzerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("Last Name Test0", outputZero.getLastname());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("Last Name Test7", outputSeven.getLastname());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Last Name Test12", outputTwelve.getLastname());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
}
