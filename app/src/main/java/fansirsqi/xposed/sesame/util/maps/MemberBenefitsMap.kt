package fansirsqi.xposed.sesame.util.maps

class MemberBenefitsMap : IdMapManager() {
    protected override fun thisFileName(): String {
        return "MemberBenefitsMap.json" // 会员权益兑换映射表
    }
}
