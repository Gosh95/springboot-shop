package com.project.shop.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("snack")
public class Snack extends Item {
}
