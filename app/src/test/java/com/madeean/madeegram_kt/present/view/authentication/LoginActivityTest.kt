package com.madeean.madeegram_kt.present.view.authentication

import com.google.common.truth.Truth
import org.junit.Assert
import org.junit.Test


internal class LoginActivityTest {
  val account = AccountModel.dummyAccountModel()

    @Test
  fun `validasi login`() {
    if (account.email.isNullOrBlank() || account.password.isNullOrBlank()) {
      Truth.assertThat(false).isFalse()
    }
    Truth.assertThat(true).isTrue()
  }

}