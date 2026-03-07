package fansirsqi.xposed.sesame.task.antOcean

import fansirsqi.xposed.sesame.hook.RequestManager
import fansirsqi.xposed.sesame.util.Log
import fansirsqi.xposed.sesame.util.RandomUtil
import org.json.JSONArray
import org.json.JSONObject

/**
 * 神奇海洋 RPC调用
 * @author Constanline
 * @since 2023/08/01
 */
object AntOceanRpcCall {
    private const val VERSION = "20241203"
    private const val SOURCE_APP_CENTER = "chInfo_ch_appcenter__chsub_9patch"
    private const val SOURCE_ATLAS = "chInfo_ch_url-https://2021003115672468.h5app.alipay.com/www/atlasOcean.html"
    private const val SOURCE_FOREST = "ANT_FOREST"
    private const val SOURCE_OCEAN = "ANTFOCEAN"
    private const val SOURCE_RECENTLY_USED = "chInfo_ch_appcollect__chsub_my-recentlyUsed"
    
    private fun getUniqueId(): String {
        return "${System.currentTimeMillis()}${RandomUtil.nextLong()}"
    }
    
    @JvmStatic
    fun queryOceanStatus(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryOceanStatus",
            "[{\"source\":\"$SOURCE_APP_CENTER\"}]"
        )
    }
    
    @JvmStatic
    fun queryHomePage(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryHomePage",
            "[{\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun cleanOcean(userId: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.cleanOcean",
            "[{\"cleanedUserId\":\"$userId\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun ipOpenSurprise(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.ipOpenSurprise",
            "[{\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun collectReplicaAsset(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.collectReplicaAsset",
            "[{\"replicaCode\":\"avatar\",\"source\":\"senlinzuoshangjiao\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun receiveTaskAward(sceneCode: String, taskType: String): String {
        return RequestManager.requestString(
            "com.alipay.antiep.receiveTaskAward",
            "[{\"ignoreLimit\":false,\"requestType\":\"RPC\",\"sceneCode\":\"$sceneCode\",\"source\":\"$SOURCE_OCEAN\",\"taskType\":\"$taskType\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun finishTask(sceneCode: String, taskType: String): String {
        val outBizNo = "${taskType}_${RandomUtil.nextDouble()}"
        return RequestManager.requestString(
            "com.alipay.antiep.finishTask",
            "[{\"outBizNo\":\"$outBizNo\",\"requestType\":\"RPC\",\"sceneCode\":\"$sceneCode\",\"source\":\"$SOURCE_OCEAN\",\"taskType\":\"$taskType\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun unLockReplicaPhase(replicaCode: String, replicaPhaseCode: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.unLockReplicaPhase",
            "[{\"replicaCode\":\"$replicaCode\",\"replicaPhaseCode\":\"$replicaPhaseCode\",\"source\":\"senlinzuoshangjiao\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"20220707\"}]"
        )
    }
    
    @JvmStatic
    fun queryReplicaHome(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryReplicaHome",
            "[{\"replicaCode\":\"avatar\",\"source\":\"senlinzuoshangjiao\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun repairSeaArea(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.repairSeaArea",
            "[{\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryOceanPropList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryOceanPropList",
            "[{\"propTypeList\":\"UNIVERSAL_PIECE\",\"skipPropId\":false,\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }

    @JvmStatic
    fun createSeaAreaExtraCollect(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.createSeaAreaExtraCollect",
            "[{\"source\":\"$SOURCE_RECENTLY_USED\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun querySeaAreaDetailList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.querySeaAreaDetailList",
            "[{\"seaAreaCode\":\"\",\"source\":\"$SOURCE_APP_CENTER\",\"targetUserId\":\"\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryOceanChapterList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryOceanChapterList",
            "[{\"source\":\"$SOURCE_ATLAS\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun switchOceanChapter(chapterCode: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.switchOceanChapter",
            "[{\"chapterCode\":\"$chapterCode\",\"source\":\"$SOURCE_ATLAS\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryMiscInfo(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryMiscInfo",
            "[{\"extInfo\":{\"EMERGENCY\":${RandomUtil.nextInt(10000, 100000)}},\"queryBizTypes\":[\"EMERGENCY\",\"HOME_TIPS_REFRESH\",\"NEW_SEA_AREA_CAN_BE_REPAIRED_TIP\"],\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }

    @JvmStatic
    fun queryNotice(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.notice",
            "[{\"noticeReqList\":[{\"extInfo\":{\"fromAct\":\"dynamic_task\"},\"needDetail\":false,\"noticeType\":\"INDEX_TASK_NOTICE\"},{\"needDetail\":false,\"noticeType\":\"CULTIVATION_LIST_ENTRANCE\"},{\"needDetail\":false,\"noticeType\":\"INDEX_GAME_ENTRY_NOTICE\"},{\"needDetail\":false,\"noticeType\":\"INTERACT_RECEIVE_PIECE\"}],\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }

    @JvmStatic
    fun popupWin(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.popupWin",
            "[{\"actionCodes\":[\"OCEAN_HOME\",\"OCEAN_POP_UP\"],\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }

    @JvmStatic
    fun queryRefinedMaterial(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryRefinedMaterial",
            "[{\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun combineFish(fishId: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.combineFish",
            "[{\"fishId\":\"$fishId\",\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun collectEnergy(bubbleId: String, userId: String): String {
        return RequestManager.requestString(
            "alipay.antmember.forest.h5.collectEnergy",
            "[{\"bubbleIds\":[$bubbleId],\"channel\":\"ocean\",\"source\":\"ANT_FOREST\",\"uniqueId\":\"${getUniqueId()}\",\"userId\":\"$userId\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun cleanFriendOcean(userId: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.cleanFriendOcean",
            "[{\"cleanedUserId\":\"$userId\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryFriendPage(userId: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryFriendPage",
            "[{\"friendUserId\":\"$userId\",\"interactFlags\":\"T\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun queryUserRanking(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryUserRanking",
            "[{\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }

    /**
     * 补全好友可清理标记（用于翻页/扩展清理名单）
     */
    @JvmStatic
    fun fillUserFlag(userIdList: JSONArray): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.fillUserFlag",
            "[{\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\",\"userIdList\":$userIdList}]"
        )
    }
    
    // ==================== 保护海洋净滩行动 ====================
    
    @JvmStatic
    fun queryCultivationList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryCultivationList",
            "[{\"source\":\"$SOURCE_FOREST\",\"version\":\"20231031\"}]"
        )
    }
    
    @JvmStatic
    fun queryCultivationDetail(cultivationCode: String, projectCode: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryCultivationDetail",
            "[{\"cultivationCode\":\"$cultivationCode\",\"projectCode\":\"$projectCode\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun oceanExchangeTree(cultivationCode: String, projectCode: String): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.exchangeTree",
            "[{\"cultivationCode\":\"$cultivationCode\",\"projectCode\":\"$projectCode\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    // ==================== 答题 ====================
    
    @JvmStatic
    fun getQuestion(): String {
        return RequestManager.requestString(
            "com.alipay.reading.game.dada.openDailyAnswer.getQuestion",
            "[{\"activityId\":\"363\",\"dadaVersion\":\"1.3.0\",\"version\":1}]"
        )
    }
    
    @JvmStatic
    fun record(): String {
        return RequestManager.requestString(
            "com.alipay.reading.game.dada.mdap.record",
            "[{\"behavior\":\"visit\",\"dadaVersion\":\"1.3.0\",\"version\":\"1\"}]"
        )
    }
    
    @JvmStatic
    fun submitAnswer(answer: String, questionId: String): String {
        return RequestManager.requestString(
            "com.alipay.reading.game.dada.openDailyAnswer.submitAnswer",
            "[{\"activityId\":\"363\",\"answer\":\"$answer\",\"dadaVersion\":\"1.3.0\",\"outBizId\":\"ANTOCEAN_DATI_PINTU_722_new\",\"questionId\":\"$questionId\",\"version\":\"1\"}]"
        )
    }
    
    // ==================== 潘多拉任务 ====================
    
    @JvmStatic
    fun PDLqueryReplicaHome(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryReplicaHome",
            "[{\"replicaCode\":\"avatar\",\"source\":\"seaAreaList\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryTaskList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryTaskList",
            "[{\"extend\":{},\"fromAct\":\"dynamic_task\",\"sceneCode\":\"ANTOCEAN_TASK\",\"source\":\"$SOURCE_FOREST\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun PDLqueryTaskList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryTaskList",
            "[{\"fromAct\":\"dynamic_task\",\"sceneCode\":\"ANTOCEAN_AVATAR_TASK\",\"source\":\"seaAreaList\",\"uniqueId\":\"${getUniqueId()}\",\"version\":\"$VERSION\"}]"
        )
    }
    
    @JvmStatic
    fun PDLreceiveTaskAward(taskType: String): String {
        return RequestManager.requestString(
            "com.alipay.antiep.receiveTaskAward",
            "[{\"ignoreLimit\":\"false\",\"requestType\":\"RPC\",\"sceneCode\":\"ANTOCEAN_AVATAR_TASK\",\"source\":\"$SOURCE_OCEAN\",\"taskType\":\"$taskType\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    // ==================== 制作万能拼图 ====================
    
    @JvmStatic
    fun exchangePropList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryOceanPropList",
            "[{\"skipPropId\":false,\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun exchangeProp(): String {
        val timestamp = System.currentTimeMillis()
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.exchangeProp",
            "[{\"bizNo\":$timestamp,\"exchangeNum\":1,\"propCode\":\"UNIVERSAL_PIECE\",\"propType\":\"UNIVERSAL_PIECE\",\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    // ==================== 使用万能拼图 ====================
    
    @JvmStatic
    fun usePropByTypeList(): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryOceanPropList",
            "[{\"propTypeList\":\"UNIVERSAL_PIECE\",\"skipPropId\":false,\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun queryFishList(pageNum: Int): String {
        return RequestManager.requestString(
            "alipay.antocean.ocean.h5.queryFishList",
            "[{\"combineStatus\":\"UNOBTAINED\",\"needSummary\":\"Y\",\"pageNum\":$pageNum,\"source\":\"$SOURCE_APP_CENTER\",\"targetUserId\":\"\",\"uniqueId\":\"${getUniqueId()}\"}]"
        )
    }
    
    @JvmStatic
    fun usePropByType(propCode: String, assets: Int, attachAssetsSet: Set<Int>): String? {
        return try {
            if (attachAssetsSet.isNotEmpty()) {
                val jsonArray = JSONArray()
                for (attachAssets in attachAssetsSet) {
                    val jsonObject = JSONObject().apply {
                        put("assets", assets)
                        put("assetsNum", 1)
                        put("attachAssets", attachAssets)
                        put("propCode", propCode)
                    }
                    jsonArray.put(jsonObject)
                }
                RequestManager.requestString(
                    "alipay.antocean.ocean.h5.usePropByType",
                    "[{\"assetsDetails\":$jsonArray,\"propCode\":\"$propCode\",\"propType\":\"UNIVERSAL_PIECE\",\"source\":\"$SOURCE_APP_CENTER\",\"uniqueId\":\"${getUniqueId()}\"}]"
                )
            } else {
                null
            }
        } catch (e: Exception) {
            Log.printStackTrace(e)
            null
        }
    }
}
