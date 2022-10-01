package com.project.shop.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cloth")
public class Cloth extends Item {
}
