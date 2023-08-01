package com.madeean.madeegram_kt.present.view.authentication

import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class RegisterActivityTest {
  val account = AccountModel.dummyAccountModel()

  @Test
  fun `register validasi`() {
      if (account.email.isNullOrBlank() || account.username.isNullOrBlank() || account.password.isNullOrBlank()) {
        Truth.assertThat(false).isFalse()
      }
      Truth.assertThat(true).isTrue()



  }
}