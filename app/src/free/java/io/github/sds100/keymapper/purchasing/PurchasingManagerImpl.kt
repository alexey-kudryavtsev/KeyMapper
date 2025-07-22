package io.github.sds100.keymapper.purchasing

import android.content.Context
import io.github.sds100.keymapper.util.Result
import io.github.sds100.keymapper.util.State
import io.github.sds100.keymapper.util.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class PurchasingManagerImpl(
    context: Context,
    private val coroutineScope: CoroutineScope,
) : PurchasingManager {
    override val onCompleteProductPurchase: MutableSharedFlow<ProductId> = MutableSharedFlow()
    override val purchases: Flow<State<Result<Set<ProductId>>>> =
        MutableStateFlow(State.Data(Success(ProductId.values().toSet())))

    override suspend fun launchPurchasingFlow(product: ProductId): Result<Unit> {
        return Success(Unit)
    }

    override suspend fun getProductPrice(product: ProductId): Result<String> {
        return Success("Free")
    }

    override suspend fun isPurchased(product: ProductId): Result<Boolean> {
        return Success(true)
    }

    override fun refresh() {}
}
