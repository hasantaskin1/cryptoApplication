package com.hasantaskin.cryptoapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Hilt, Android uygulamalarında bağımlılık enjeksiyonunu kolaylaştırmak,
// kodun test edilebilirliğini artırmak ve daha modüler bir yapı sağlamak için kullanılan bir kütüphanedir.
// Android'de bağımlılıkları yönetmek için daha verimli ve anlaşılır bir yol sunar.

@HiltAndroidApp
class CryptoApplication : Application()
