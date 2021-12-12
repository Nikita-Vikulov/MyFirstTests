package com.example.testapplication

import junit.framework.Assert.*
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }
    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name"))
    }
    @Test
    fun emailValidator_NoDomain_ReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("name@"))
    }
    @Test
    fun emailValidator_GetDomainLength_ReturnEqual() {
        assertEquals(EmailValidator.lengthDomainName("name@domain.com"), 10)
    }

    @Test
    fun emailValidator_GetUserLength_ReturnEqual() {
        assertEquals(EmailValidator.lengthUserName("name@domain.com"), 4)
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

}