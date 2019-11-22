package com.kyw.lolgames;

/**
 * @author : kangyw
 * @date : 下午 15:07 2019/11/20
 */
public class HerosEntity {

    /**英雄名称*/
    private String name;

    /**血量*/
    private float hp;

    /**蓝量*/
    private float mp;

    /**攻击力*/
    private float ad;

    /**暴击率*/
    private double critRate;

    /**技能描述*/
    private String skillDescription;

    /**技能伤害*/
    private float skillsVal;

    /**技能消耗*/
    private float skillCost;

    /**护甲*/
    private float armor;

    /**魔抗*/
    private float magicResistance;

    public HerosEntity() {
    }

    public HerosEntity(String name, float hp, float mp, float ad, double critRate,
                       String skillDescription, float skillsVal, float skillCost, float armor, float magicResistance) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.ad = ad;
        this.critRate = critRate;
        this.skillDescription = skillDescription;
        this.skillsVal = skillsVal;
        this.skillCost = skillCost;
        this.armor = armor;
        this.magicResistance = magicResistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getMp() {
        return mp;
    }

    public void setMp(float mp) {
        this.mp = mp;
    }

    public float getAd() {
        return ad;
    }

    public void setAd(float ad) {
        this.ad = ad;
    }

    public double getCritRate() {
        return critRate;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public float getSkillsVal() {
        return skillsVal;
    }

    public void setSkillsVal(float skillsVal) {
        this.skillsVal = skillsVal;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public float getMagicResistance() {
        return magicResistance;
    }

    public void setMagicResistance(float magicResistance) {
        this.magicResistance = magicResistance;
    }

    public float getSkillCost() {
        return skillCost;
    }

    public void setSkillCost(float skillCost) {
        this.skillCost = skillCost;
    }

    /**
     * 英雄被攻击
     */
    public float beAttacked(float attackAD){
        return hp = this.hp - attackAD;
    }

    /**
     * 英雄使用技能，mp减少
     */
    public void releaseSkills(HerosEntity enemy){
        if(this.getMp() >= this.getSkillCost()){
            System.out.println(this.getName()+"使用了技能：'"+this.getSkillDescription()
                    +"',对"+enemy.getName()+"造成了'"+this.getSkillsVal()+"'点伤害!");
            enemy.setHp(enemy.getHp()-this.skillsVal);
            this.setMp(this.getMp()-this.getSkillCost());
        }else{
            System.out.println("MP值不够，无法发动技能！");
        }
    }
}
