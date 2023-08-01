package com.madeean.madeegram_kt.present.view.authentication

import com.madeean.madeegram_kt.present.view.model.AccountModelPresent

object AccountModel{
  fun dummyAccountModel() =AccountModelPresent(
    username = "test",
    email = "test@gmail.com",
    password = "123"
  )
}
