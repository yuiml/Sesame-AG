package fansirsqi.xposed.sesame.ui.extension

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fansirsqi.xposed.sesame.ui.viewmodel.MainViewModel.Companion.verifuids

@Suppress("UNUSED_PARAMETER")
@Composable
fun WatermarkLayer(
    modifier: Modifier = Modifier,
    // 🔥 核心修改：接收 UID 列表作为参数，而不是读取静态变量
    uidList: List<String?> = verifuids,
    autoRefresh: Boolean = true,
    refreshIntervalMs: Long = 1000L,
    refreshTrigger: Any? = null,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) { content() }
}
