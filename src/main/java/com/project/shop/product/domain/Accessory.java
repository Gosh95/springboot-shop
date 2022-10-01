package com.project.shop.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("accessory")
public class Accessory extends Item {
}
