package com.example.navcomponent2

import com.example.navcomponent2.model.accounts.AccountsRepository
import com.example.navcomponent2.model.accounts.InMemoryAccountsRepository
import com.example.navcomponent2.model.boxes.BoxesRepository
import com.example.navcomponent2.model.boxes.InMemoryBoxesRepository

object Repositories {

    val accountsRepository: AccountsRepository = InMemoryAccountsRepository()

    val boxesRepository: BoxesRepository = InMemoryBoxesRepository(accountsRepository)

}